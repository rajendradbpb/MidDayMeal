package com.goapps.midday.repository.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.goapps.midday.valueobject.user.UserCount;

@Repository
public class UserDaoImpl implements IUserDao {

	
	@Autowired
	JdbcTemplate jdbcTemplate;

	Logger LOG = LoggerFactory.getLogger(UserDaoImpl.class);
	
	
	@Override
	@Transactional(readOnly=true)
	public List<UserCount> getUserCounts(Long SchoolId) {
		List<UserCount> userCountList = new ArrayList<>();
		try {
			
			String sql = "select r.name, count(*) as count from user u, role r where u.role_id = r.role_id and u.school_id = " + SchoolId+
					" group by r.name ";
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
			for (Map row : rows) {
				UserCount obj = new UserCount();
				
				obj.setName(((String) row.get("name")));
				obj.setCount((Long) row.get("count"));
				userCountList.add(obj);
			}
		} catch (DataAccessException e) {
			LOG.error(e.getMessage());
			throw e;
		}
		catch (Exception e) {
			LOG.error(e.getMessage());
			throw e;
		}

        return userCountList;
	}

}