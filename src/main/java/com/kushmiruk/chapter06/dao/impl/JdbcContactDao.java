package com.kushmiruk.chapter06.dao.impl;

import com.kushmiruk.chapter06.dao.ContactDao;
import com.kushmiruk.chapter06.domain.Contact;
import com.kushmiruk.chapter06.domain.ContactTelDetail;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.object.SqlUpdate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository("contactDao")
public class JdbcContactDao implements ContactDao, InitializingBean {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public List<Contact> findAll() {
        String sql = "Select * from contact";
        return namedParameterJdbcTemplate.query(sql, (resultSet, rowNum) -> {
            Contact contact = new Contact();
            contact.setId(resultSet.getLong("id"));
            contact.setFirstName(resultSet.getString("first_name"));
            contact.setLastName(resultSet.getString("last_name"));
            contact.setBirthDate(resultSet.getDate("birth_date"));
            return contact;
        });
    }

    @Override
    public List<Contact> findAllWithDetail() {
        String sql = "select c.id, c.first_name,c.last_name,c.birth_date" +
                ",t.id as contact_tel_id, t.tel_type,t.tel_number from contact c" +
                " left join contact_tel_detail t on c.id=t.contact_id ";

        return namedParameterJdbcTemplate.query(sql, (resultSet) -> {
            Map<Long, Contact> map = new HashMap<>();
            Contact contact = null;
            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                contact = map.get(id);

                if (contact == null) {
                    contact = new Contact();
                    contact.setId(resultSet.getLong("id"));
                    contact.setFirstName(resultSet.getString("first_name"));
                    contact.setLastName(resultSet.getString("last_name"));
                    contact.setBirthDate(resultSet.getDate("birth_date"));
                    contact.setContactTelDetails(new ArrayList<>());
                    map.put(id, contact);
                }

                Long contactTelDetailId = resultSet.getLong("contact_tel_id");

                if (contactTelDetailId > 0) {
                    ContactTelDetail contactTelDetail = new ContactTelDetail();
                    contactTelDetail.setId(contactTelDetailId);
                    contactTelDetail.setContactId(id);
                    contactTelDetail.setTelType(resultSet.getString("tel_type"));
                    contactTelDetail.setTelNumber(resultSet.getString("tel_number"));
                    contact.getContactTelDetails().add(contactTelDetail);
                }


            }
            return new ArrayList<>(map.values());
        });
    }

    @Override
    public List<Contact> findByFirstName(String firstName) {
        return null;
    }

    @Override
    public String findFirstNameById(Long id) {
        return jdbcTemplate.queryForObject("Select first_name from contact where id=?",
                new Object[]{id}, String.class);
    }

    @Override
    public String findLastNameById(Long id) {
        String sql = "Select last_name from contact where id = :contactId";
        Map<String, Object> namedParameters = new HashMap<>();
        namedParameters.put("contactId", id);
        return namedParameterJdbcTemplate.queryForObject(sql, namedParameters, String.class);
    }

    @Override
    public Contact findById(Long id) {
        return null;
    }

    @Override
    public void insert(Contact contact) {

    }

    @Override
    public void update(Contact contact) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("first_name", contact.getFirstName());
        paramMap.put("last_name", contact.getLastName());
        paramMap.put("birth_date", contact.getBirthDate());
        paramMap.put("id", contact.getId());

        String sql = "update contact set first_name=:first_name," +
                "last_name=:last_name,birth_date=:birth_date where id = :id";
        SqlUpdate sqlUpdate = new SqlUpdate(dataSource, sql);
        sqlUpdate.declareParameter(new SqlParameter("first_name", Types.VARCHAR));
        sqlUpdate.declareParameter(new SqlParameter("last_name", Types.VARCHAR));
        sqlUpdate.declareParameter(new SqlParameter("birth_date", Types.DATE));
        sqlUpdate.declareParameter(new SqlParameter("id", Types.INTEGER));

        sqlUpdate.updateByNamedParam(paramMap);
    }

    @Override
    public void delete(Contact contact) {

    }

    @Resource(name = "dataSource")
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if (dataSource == null) {
            throw new BeanCreationException("Must see dataSource on ContactDao");
        }
    }

}
