package com.diamler.demo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.diamler.demo.model.ScheduleModel;

@CrossOrigin()
@RestController
public class Restcontroller {

	public static List<ScheduleModel> gresult = extracted();

	@GetMapping(value = "/getsingleplan/{id}")
	public ScheduleModel getPlan(@PathVariable long id) {
		return gresult.stream().filter(i -> i.getSid() == id).findFirst().get();

	}

	@GetMapping(value = "/getresult")
	public List<ScheduleModel> getTodaysPlans() {
		return gresult;
	}

	private static List<ScheduleModel> extracted() {
		List<ScheduleModel> result = new ArrayList<>();
		ScheduleModel obj = new ScheduleModel();
		obj.setSid(0);
		obj.setName("nikhil");
		obj.setEndtime(new Date().toString());
		obj.setStarttime(new Date().toString());
		result.add(obj);
		ScheduleModel obj1 = new ScheduleModel();
		obj1.setSid(1);
		obj1.setName("sdjl");
		obj1.setEndtime(new Date().toString());
		obj1.setStarttime(new Date().toString());
		result.add(obj1);
		ScheduleModel obj11 = new ScheduleModel();
		obj11.setSid(3);
		obj11.setName("sljd");
		obj11.setEndtime(new Date().toString());
		obj11.setStarttime(new Date().toString());
		result.add(obj11);
		ScheduleModel obj111 = new ScheduleModel();
		obj111.setSid(4);
		obj111.setName("sljd");
		obj111.setEndtime(new Date().toString());
		obj111.setStarttime(new Date().toString());
		result.add(obj111);
		ScheduleModel obj1111 = new ScheduleModel();
		obj1111.setSid(5);
		obj1111.setName("sljd");
		obj1111.setEndtime(new Date().toString());
		obj1111.setStarttime(new Date().toString());
		result.add(obj1111);
		return result;
	}

	@DeleteMapping(value = "/delete/{id}")
	public boolean delete(@PathVariable long id) {
		return gresult.removeIf(i -> i.getSid() == id);
	}

	@PostMapping(value = "/save")
	public boolean save(@RequestBody ScheduleModel sm) {

		return gresult.add(sm);

	}
	@PostMapping(value = "/update")
	public boolean update(@RequestBody ScheduleModel sm) {
		gresult.forEach(action->{
			if(action.getSid()==sm.getSid()) {
				action.setEndtime(sm.getEndtime());
				action.setStarttime(sm.getStarttime());
				action.setName(sm.getName());
			}
		});
		return gresult.add(sm);

	}

}
