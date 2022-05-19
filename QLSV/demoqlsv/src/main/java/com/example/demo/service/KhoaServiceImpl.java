package com.example.demo.service;

import com.example.demo.entity.Khoa;
import com.example.demo.repository.KhoaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class KhoaServiceImpl implements KhoaService {

    @Autowired
    private KhoaRepository khoaRepository;

    @Override
    public List<Khoa> getAllKhoa() {
        List<Khoa> listKhoa = khoaRepository.findAll();
        return listKhoa;
    }
}
