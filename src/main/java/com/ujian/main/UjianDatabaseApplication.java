package com.ujian.main;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ujian.main.entity.Admin;
import com.ujian.main.entity.Dosen;
import com.ujian.main.entity.Mahasiswa;
import com.ujian.main.entity.MataKuliah;
import com.ujian.main.entity.Nilai;
import com.ujian.main.entity.Pertanyaan;
import com.ujian.main.entity.Plotmatakuliah;
import com.ujian.main.entity.Soal;
import com.ujian.main.repository.AdminRepository;
import com.ujian.main.repository.DosenRepository;
import com.ujian.main.repository.MKRepository;
import com.ujian.main.repository.MahasiswaRepository;
import com.ujian.main.repository.NilaiRepository;
import com.ujian.main.repository.PertanyaanRepository;
import com.ujian.main.repository.PlotmatakuliahRepository;
import com.ujian.main.repository.SoalRepository;

@SpringBootApplication
public class UjianDatabaseApplication implements CommandLineRunner {
	
	@Autowired
	private PlotmatakuliahRepository plotMK;
	
	@Autowired
	private SoalRepository soalRepo;

	public static void main(String[] args) {
		SpringApplication.run(UjianDatabaseApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		/*
		Admin admin =new Admin();
		admin.setUsername("russel2");
		admin.setPassword("dknsal");
		
		adminRepository.save(admin);
		
		PlotMataKuliah plot = new PlotMataKuliah();
				
		MataKuliah mk = new MataKuliah();
		mk.setNama_mk("Fisika");
		
		plot.setMatakuliah(mk);
		
		Dosen ds = new Dosen();
		ds.setNama_dosen("Rusli Wanasuria");
		ds.setUsername(111);
		ds.setPassword("bdkjbak2888");
		
		plot.setDosen(ds);

		Mahasiswa mh = new Mahasiswa();
		mh.setNm_mh("Adam");
		mh.setJk("Laki-Laki");
		mh.setPassword("djjjd2233");
		
		plot.setMahasiswa(mh);
		
		Soal soal = new Soal();
		soal.setNama_soal("Soal_English");
		soal.setStatus(1);

		List<Soal> lstsoal = new ArrayList<Soal>();
		lstsoal.add(soal);
		
		plot.setLstSoal(lstsoal);		
		
		Nilai nilai = new Nilai();
		nilai.setNilai("100");
		
		soal.setNilai(nilai);
		
		Pertanyaan tanya = new Pertanyaan();
		tanya.setPertanyaan("Apakah itu?");
		tanya.setJawaban1("ini adalah budi");
		tanya.setJawaban2("ini adalah rudi");
		tanya.setJawaban3("ini adalah ludi");
		tanya.setJawaban4("ini adalah hudi");
		tanya.setJawaban_benar("ini adalah budi");
		tanya.setStatus_gambar(3);
		
		List<Pertanyaan> lstPertanyaan = new ArrayList<Pertanyaan>();
		lstPertanyaan.add(tanya);
		soal.setLstPertanyaan(lstPertanyaan);
		
		plot.setLstSoal(lstsoal);
		this.plotMK.save(plot);
		
		Soal soalx = this.soalRepo.findBynama_soal("Soal Percintaan");
		
		System.out.println(soalx.getNama_soal());

		*/
		
		
	}

}
