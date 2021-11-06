package springboot.student.app.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import springboot.student.app.bean.StudentBean;
import springboot.student.app.repo.StudentRepository;
import springboot.student.app.services.StudentServices;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class StudentController {
	@Autowired
	private StudentRepository studrepo;
	@Autowired
	private StudentServices studser;
	@RequestMapping("/display")
	public String getdata()
	{
		return "hello";
	}
	@PostMapping("/create")
	public void create(@RequestBody StudentBean stu)
	{
		String s1=String.valueOf(studser.getNextSequence(StudentBean.Sqe_name));
		int i=s1.length();
		if(i==1) {
			String sid="R_"+"00"+s1;
			stu.setId(sid);
		}else if(i==2) {
			String sid="R_"+"0"+s1;
			stu.setId(sid);
		}else {
			stu.setId("R_"+s1);
		}
		studrepo.insert(stu);
	}
	@PostMapping("/delete/{id}")
	public void delete(@PathVariable String id)
	{
		studrepo.deleteById(id);
	}
	@GetMapping("/list")
	public List <StudentBean> view()
	{
		return studrepo.findByOrderByNameAsc();
	}
	

}
