package mjg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class SpringJdbcPersonDAO implements PersonDAO {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public SpringJdbcPersonDAO(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Person findById(Long id) {
        String sql = "select id, first, last from Person where id=?";
        return jdbcTemplate.queryForObject(sql, new PersonMapper(), id);
    }

    @Override
    public List<Person> findAll() {
        String sql = "select id, first, last from Person";
        return jdbcTemplate.query(sql, new PersonMapper());
    }

    @Override
    public long insertPerson(Person person) {
        String sql = "insert into PERSON(id, first, last) values(?,?,?)";
        jdbcTemplate.update(sql, person.getId(), person.getFirst(), person.getLast());
        return person.getId();
    }

    @Override
    public void deletePerson(Long id) {
        String sql = "delete from PERSON where id=?";
        jdbcTemplate.update(sql, id);
    }

    private final static class PersonMapper implements RowMapper<Person> {
        @Override
        public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Person(rs.getLong("id"),
                    rs.getString("first"),
                    rs.getString("last"));
        }
    }

}
