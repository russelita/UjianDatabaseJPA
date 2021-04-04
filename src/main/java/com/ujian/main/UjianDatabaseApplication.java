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
import com.ujian.main.entity.PlotMataKuliah;
import com.ujian.main.entity.Soal;
import com.ujian.main.repository.AdminRepository;
import com.ujian.main.repository.DosenRepository;
import com.ujian.main.repository.MKRepository;
import com.ujian.main.repository.MahasiswaRepository;
import com.ujian.main.repository.NilaiRepository;
import com.ujian.main.repository.PertanyaanRepository;
import com.ujian.main.repository.PlotMataKuliahRepository;
import com.ujian.main.repository.SoalRepository;

@SpringBootApplication
public class UjianDatabaseApplication implements CommandLineRunner {
	
	@Autowired
	AdminRepository adminRepository;
	
	@Autowired
	DosenRepository dosenRepository;
	
	@Autowired
	MahasiswaRepository mahasiswaRepository;
	
	@Autowired
	MKRepository mkRepository;
	
	@Autowired
	PlotMataKuliahRepository plotmatakuliahRepository;
	
	@Autowired
	SoalRepository soalRepository;
	
	@Autowired
	NilaiRepository nilaiRepository;
	
	@Autowired
	PertanyaanRepository tanyaRepository;

	public static void main(String[] args) {
		SpringApplication.run(UjianDatabaseApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Admin admin =new Admin();
		admin.setUsername("russel2");
		admin.setPassword("dknsal");
		
		adminRepository.save(admin);
				
		MataKuliah mk = new MataKuliah();
		mk.setNama_mk("Fisika");
		
		MataKuliah mk1 = new MataKuliah();
		mk1.setNama_mk("Matematika");
		
		List<MataKuliah> lstmk = new ArrayList<MataKuliah>();
		lstmk.add(mk);
		lstmk.add(mk1);
				
		Dosen ds = new Dosen();
		ds.setNama_dosen("Rusli Wanasuria");
		ds.setUsername(111);
		ds.setPassword("bdkjbak2888");
		
		Dosen ds1 = new Dosen();
		ds1.setNama_dosen("Juara Coding");
		ds1.setUsername(536);
		ds1.setPassword("jhksajdh222");
		
		List<Dosen> lstdosen = new ArrayList<Dosen>();
		lstdosen.add(ds);
		lstdosen.add(ds1);
		
		Mahasiswa mh = new Mahasiswa();
		mh.setNm_mh("Adam");
		mh.setJk("Laki-Laki");
		mh.setPassword("djjjd2233");
		
		Mahasiswa mh1 = new Mahasiswa();
		mh1.setNm_mh("Agnes");
		mh1.setJk("Perempuan");
		mh1.setPassword("sndnjs111");
		
		List<Mahasiswa> lstmh = new ArrayList<Mahasiswa>();
		lstmh.add(mh);
		lstmh.add(mh1);
		
		Soal soal = new Soal();
		soal.setId_soal(2);
		soal.setNama_soal("Soal_English");
		soal.setStatus(1);
		
		Soal soal1 = new Soal();
		soal1.setId_soal(1);
		soal1.setNama_soal("Soal_BHS");
		soal1.setStatus(4);

		List<Soal> lstsoal = new ArrayList<Soal>();
		lstsoal.add(soal);
		lstsoal.add(soal1);		
		
		PlotMataKuliah plot = new PlotMataKuliah();
		plot.setLstdosen(lstdosen);
		plot.setLstmh(lstmh);
		plot.setLstmk(lstmk);
		plot.setLstsoal(lstsoal);
//		List<PlotMataKuliah> lstplot = new ArrayList<PlotMataKuliah>();
//		soal.setLstdosen(lstdosen);
//		soal.setLstmh(lstmh);
//		soal.setLstmk(lstmk);
		
		this.plotmatakuliahRepository.save(plot);
		
		Nilai nilai = new Nilai();
		nilai.setNilai(100);
		
		Nilai nilai1 = new Nilai();
		nilai1.setNilai(200);
		
		List<Nilai> lstnilai = new ArrayList<Nilai>();
		lstnilai.add(nilai);
		lstnilai.add(nilai1);
		
		Pertanyaan tanya = new Pertanyaan();
		tanya.setPertanyaan("Apakah itu?");
		tanya.setJawaban1("ini adalah budi");
		tanya.setJawaban2("ini adalah rudi");
		tanya.setJawaban3("ini adalah ludi");
		tanya.setJawaban4("ini adalah hudi");
		tanya.setJawaban_benar("ini adalah budi");
		tanya.setStatus_gambar(3);
		tanya.setLstnilai(lstnilai);
		
		this.tanyaRepository.save(tanya);

		
		
		
	}

}
