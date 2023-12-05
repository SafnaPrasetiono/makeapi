package com.makeapi.controller;

import org.json.JSONObject;
// import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.makeapi.model.mahasiswa.MahasiswaModel;
import com.makeapi.model.response.ResultResponse;
import com.makeapi.services.MahasiswaServices;

@RestController
public class MahasiswaController {

    @Autowired
    MahasiswaServices mahasiswaServices;

    @GetMapping("/mahasiswa/data")
    public ResponseEntity<Object> datap() {
        ResultResponse result = new ResultResponse();
        result = mahasiswaServices.MahasiswaData();
        return new ResponseEntity<Object>(result.getResponsed(), result.getStatusResponse());
    }

    @PostMapping("/mahasiswa/create")
    public ResponseEntity<Object> create(@RequestBody MahasiswaModel mahasiswaMOdel) {
        ResultResponse result = new ResultResponse();
        result = mahasiswaServices.MahasiswaCreate(mahasiswaMOdel);
        return new ResponseEntity<Object>(result.getResponsed(), result.getStatusResponse());
    }

    @DeleteMapping("/mahasiswa/delete")
    public ResponseEntity<Object> postMethodName(@RequestBody String param) {
        ResultResponse result = new ResultResponse();
        JSONObject objParam = new JSONObject(param);
        result = mahasiswaServices.MahasiswaDelete(objParam);
        return new ResponseEntity<Object>(result.getResponsed(), result.getStatusResponse());
    }

    // @PutMapping("/mahasiswa/update/{id}")
    // public ResponseEntity<MahasiswaModel> updateEmployee(@PathVariable(value =
    // "id") BigInteger employeeId,
    // @RequestBody MahasiswaModel mahasiswaMOdel) {
    // MahasiswaModel employee = mainRepository.findById(employeeId).get();
    // if(employee != null){
    // employee.setADDRESS(mahasiswaMOdel.getADDRESS());
    // employee.setBORN(mahasiswaMOdel.getBORN());
    // employee.setEMAIL(mahasiswaMOdel.getEMAIL());
    // employee.setFAKULTAS(mahasiswaMOdel.getFAKULTAS());
    // employee.setJURUSAN(mahasiswaMOdel.getJURUSAN());
    // employee.setNPM(mahasiswaMOdel.getNPM());
    // employee.setPHONE(mahasiswaMOdel.getPHONE());
    // employee.setUSERNAME(mahasiswaMOdel.getUSERNAME());
    // mainRepository.save(employee);
    // }
    // return ResponseEntity.ok(employee);
    // }
}
