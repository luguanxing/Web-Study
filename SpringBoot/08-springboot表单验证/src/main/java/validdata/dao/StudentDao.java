package validdata.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import validdata.entity.Student;

/**
 * 学生信息Dao接口
 * @author Administrator
 *
 */
public interface StudentDao extends JpaRepository<Student, Integer>{

}
