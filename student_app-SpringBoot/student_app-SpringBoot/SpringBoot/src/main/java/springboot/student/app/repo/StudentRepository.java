package springboot.student.app.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import springboot.student.app.bean.StudentBean;

public interface StudentRepository extends MongoRepository<StudentBean,String> {

	public List<StudentBean> findByOrderByNameAsc();
}
