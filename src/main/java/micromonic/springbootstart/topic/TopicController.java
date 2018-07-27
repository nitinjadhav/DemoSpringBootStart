package micromonic.springbootstart.topic;
 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {

	@Autowired
	private TopicService topicService;
	
	
	@RequestMapping("/")
	public String disaplyMsg() {
		return "Welcome..!!";
	}
	
	@RequestMapping("/topics")
	public List<Topic> getAllTopics(){
		
		return topicService.getAllTopics(); 			
	}
	
	@RequestMapping("/topics/{id}")
	public Topic getTopic(@PathVariable String id){
		
		return topicService.getTopic(id); 			
	}
	
	
	@RequestMapping(method=RequestMethod.POST,value="/topics")
	public String addTopic(@RequestBody Topic topic){
		
		return topicService.addTopic(topic); 			
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/topics/{id}")
	public String updateTopic(@RequestBody Topic topic,@PathVariable String id){
		
		return topicService.updateTopic(topic,id); 			
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/topics/{id}")
	public String deleteTopic(@PathVariable String id){
		
		return topicService.deletTopic(id); 			
	}
	
	 
	
	@RequestMapping("/alltopics")
	public String getAllofTopics(){

		return "Topics all";
				
	}
}
