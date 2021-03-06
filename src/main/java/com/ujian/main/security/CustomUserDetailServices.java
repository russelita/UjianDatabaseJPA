package com.ujian.main.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.ujian.main.entity.Admin;
import com.ujian.main.entity.Mahasiswa;
import com.ujian.main.repository.AdminRepository;
import com.ujian.main.repository.MahasiswaRepository;

public class CustomUserDetailServices implements UserDetailsService {
	
	@Autowired
	private AdminRepository userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Admin user = userRepo.findByUsername(username);

		if (user == null) {
			throw new UsernameNotFoundException("User not found");
		}
		return new CustomUserDetail(user);
	}

}
