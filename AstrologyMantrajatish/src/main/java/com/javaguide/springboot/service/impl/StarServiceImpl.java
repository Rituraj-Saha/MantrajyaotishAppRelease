package com.javaguide.springboot.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.javaguide.springboot.exception.ResourceNotFoundException;
import com.javaguide.springboot.model.Star;
import com.javaguide.springboot.model.StarModelForGetAll;
import com.javaguide.springboot.model.StarResponse;
import com.javaguide.springboot.model.User;
import com.javaguide.springboot.model.UserResponse;
import com.javaguide.springboot.repository.ProcessRepository;
import com.javaguide.springboot.repository.StarRepository;
import com.javaguide.springboot.repository.UserRepository;
import com.javaguide.springboot.service.StarService;

@Service
public class StarServiceImpl implements StarService {

	private StarRepository starRepository;
	private ProcessRepository processRepository;

	public StarServiceImpl(StarRepository starRepository, ProcessRepository processRepository) {
		super();
		this.starRepository = starRepository;
		this.processRepository = processRepository;

	}

	@Override
	public String getMantram(String star_id) {
		// TODO Auto-generated method stub
		Optional<com.javaguide.springboot.model.Star> star = starRepository.findById(Long.valueOf(star_id));

		if (star.isPresent()) {
			return star.get().getProcess().getMantram();
		} else {
			throw new ResourceNotFoundException("star", "mantram", star_id);
		}
	}

	@Override
	public String getJantram(String star_id) {
		Optional<com.javaguide.springboot.model.Star> star = starRepository.findById(Long.valueOf(star_id));

		if (star.isPresent()) {
			return star.get().getProcess().getJantram();
		} else {
			throw new ResourceNotFoundException("star", "jantram", star_id);
		}
	}

	@Override
	public String getTips(String star_id, String lang) {

		Optional<com.javaguide.springboot.model.Star> star = starRepository.findById(Long.valueOf(star_id));

		if (star.isPresent()) {
			if (lang.equalsIgnoreCase("bn"))
				return star.get().getProcess().getTips_bang();
			else
				return star.get().getProcess().getTips();
		} else {
			throw new ResourceNotFoundException("star", "tips", star_id);
		}
	}

	@Override
	public String getPuja(String star_id, String lang) {
		// TODO Auto-generated method stub
		Optional<com.javaguide.springboot.model.Star> star = starRepository.findById(Long.valueOf(star_id));

		if (star.isPresent()) {

			if (lang.equalsIgnoreCase("bn"))
				return star.get().getProcess().getPuja_bang();
			else
				return star.get().getProcess().getPuja();
		} else {
			throw new ResourceNotFoundException("star", "puja", star_id);
		}
	}

	@Override
	public String getStarName(String star_id) {
		Optional<com.javaguide.springboot.model.Star> star = starRepository.findById(Long.valueOf(star_id));

		if (star.isPresent()) {
			return star.get().getStar_name();
		} else {
			throw new ResourceNotFoundException("star", "name", star_id);
		}

	}

	@Override
	public List<StarResponse> getAllStars() {

		List<Star> stars = starRepository.findAll();

		List<StarResponse> mResponse = new ArrayList<StarResponse>();

		List<StarModelForGetAll> mModels = new ArrayList<StarModelForGetAll>();

		if (stars.size() > 0) {

			for (Star s : stars) {
				mModels.add(new StarModelForGetAll(s.getId(), s.getStar_name()));
			}
			for (StarModelForGetAll m : mModels) {
				mResponse.add(new StarResponse(m));
			}

			return mResponse;
		} else {
			throw new ResourceNotFoundException("star", "name", "stars length 0");
		}

	}

	@Override
	public String getGenInfo(String star_id, String lang) {
		Optional<com.javaguide.springboot.model.Star> star = starRepository.findById(Long.valueOf(star_id));

		if (star.isPresent()) {

			if (lang.equalsIgnoreCase("bn"))
				return star.get().getProcess().getGen_info_bang();
			else
				return star.get().getProcess().getGen_info();
		} else {
			throw new ResourceNotFoundException("star", "genInfo", star_id);
		}
		
	}

	@Override
	public String getJantramInfo(String star_id, String lang) {
		// TODO Auto-generated method stub
		Optional<com.javaguide.springboot.model.Star> star = starRepository.findById(Long.valueOf(star_id));

		if (star.isPresent()) {

			if (lang.equalsIgnoreCase("bn"))
				return star.get().getProcess().getJantram_info_bang();
			else
				return star.get().getProcess().getJantram_info();
		} else {
			throw new ResourceNotFoundException("star", "jantraInfo", star_id);
		}
	}

	@Override
	public String getMantraInfo(String star_id, String lang) {
		// TODO Auto-generated method stub
		Optional<com.javaguide.springboot.model.Star> star = starRepository.findById(Long.valueOf(star_id));

		if (star.isPresent()) {

			if (lang.equalsIgnoreCase("bn"))
				return star.get().getProcess().getMantram_info_bang();
			else
				return star.get().getProcess().getMantram_info();
		} else {
			throw new ResourceNotFoundException("star", "mantraInfo", star_id);
		}
	}

}
