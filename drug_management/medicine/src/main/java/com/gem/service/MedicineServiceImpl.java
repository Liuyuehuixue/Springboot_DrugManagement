package com.gem.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gem.entity.Medicine;
import com.gem.mapper.MedicineMapper;
import org.springframework.stereotype.Service;

@Service
public class MedicineServiceImpl extends ServiceImpl<MedicineMapper, Medicine> implements MedicineService{

}
