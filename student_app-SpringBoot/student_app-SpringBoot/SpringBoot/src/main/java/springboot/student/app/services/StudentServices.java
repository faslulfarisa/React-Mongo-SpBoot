package springboot.student.app.services;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;



import springboot.student.app.bean.CustomSqe;

@Service
public class StudentServices {
	@Autowired
	MongoOperations mongo;
	
	 public int getNextSequence(String seqName)
	    {
	       
	    	CustomSqe counter = mongo.findAndModify(
	                query(where("_id").is(seqName)),
	                new Update().inc("sqe",1),
	                options().returnNew(true).upsert(true),
	                CustomSqe.class);
	            return counter.getSqe();
	    }
	
	
}
