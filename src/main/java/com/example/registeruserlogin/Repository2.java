package com.example.registeruserlogin;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

@Repository

public class Repository2 {

    private final Logger logger = LoggerFactory.getLogger(Repository.class);
    BCryptPasswordEncoder bCrypt = new BCryptPasswordEncoder(15);

    @Autowired
    private JdbcTemplate db;


    //Step 1
    public boolean login(Bruker bruker) {
        String sql = "SELECT * FROM Bruker WHERE brukernavn = ?";

        try{
            Bruker b = db.queryForObject(sql, BeanPropertyRowMapper.newInstance(Bruker.class), bruker.getBrukernavn());
            if(b != null) {
                return sjekkPassord(bruker.getPassord(), b.getPassord());
            } else return false;
        }catch (Exception e) {
            logger.error("Feil med login() " + e);
            return false;
        }
    }

    public String krypterPassord(String passord) {
        return bCrypt.encode(passord);
    }

    public boolean sjekkPassord(String passord, String hashPassord) {return bCrypt.matches(passord, hashPassord);
    }


    //Step 2
    public boolean opprett(Bruker b) {
        String sql1 = "SELECT COUNT(*) FROM Bruker WHERE brukernavn = ?";
        String sql2 = "INSERT INTO Bruker (brukernavn, passord) VALUES (?, ?)";
        int antall = db.queryForObject(sql1, Integer.class, b.getBrukernavn());
        try {
            if (antall > 0) {
                return false;
            } else {
                db.update(sql2, b.getBrukernavn(), krypterPassord(b.getPassord()));
                return true;
            }
        } catch (Exception e) {
            logger.error("Feil med opprettelse av bruker " + e);
            return false;
        }
    }}
