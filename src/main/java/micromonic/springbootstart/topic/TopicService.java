package micromonic.springbootstart.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicService {

	private List<Topic> topics = new ArrayList<>(
			Arrays.asList(new Topic("Spring", "Spring Framework", "Spring Framework Information"),
					new Topic("Java", "Core Java ", "Core Java Description "),
					new Topic("JS", "JavaScript ", "JavaScript Description")));

	public List<Topic> getAllTopics() {
		return topics;
	}

	public Topic getTopic(String id) {

		return topics.stream().filter(t -> t.getId().toUpperCase().equals(id.toUpperCase())).findFirst().get();
	}

	public String addTopic(Topic topic) {
		try {
			topics.add(topic);
			return "Done";
		} catch (Exception e) {
			return "Error !!";
		}

	}

	public String deletTopic(String id) {
		try {
			
			topics.removeIf(t->t.getId().toLowerCase().equals(id.toLowerCase()));
//			for (int i = 0; i < topics.size(); i++) {
//				Topic t = topics.get(i);
//				if (t.getId().equalsIgnoreCase(id)) {
//					topics.remove(i);
//				}
//			}
			return "Done";
			}catch (Exception e) {
				return "Error !!";
			}
	}

	public String updateTopic(Topic topic, String id) {

		try {
			for (int i = 0; i < topics.size(); i++) {
				Topic t = topics.get(i);
				if (t.getId().equalsIgnoreCase(id)) {
					topics.set(i, topic);
				}
			}

			return "Done";
		} catch (Exception e) {
			return "Error !!";
		}
	}

}
