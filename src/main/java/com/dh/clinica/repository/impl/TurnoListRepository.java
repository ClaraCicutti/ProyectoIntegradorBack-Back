//package com.dh.clinica.repository.impl;
//
//import com.dh.clinica.model.Paciente;
//import com.dh.clinica.repository.IDao;
//import com.dh.clinica.model.Turno;
//import com.dh.clinica.repository.configuracion.ConfiguracionJDBC;
//import com.dh.clinica.service.OdontologoService;
//import com.dh.clinica.service.PacienteService;
//import com.dh.clinica.util.Util;
//import org.apache.log4j.Logger;
//
//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//import java.util.Optional;
//
//public class TurnoListRepository implements IDao<Turno> {
//
////    private List<Turno> turnos;
//
//    private ConfiguracionJDBC configuracionJDBC;
//    private PacienteService pacienteService = new PacienteService(new PacienteDaoH2(new DomicilioDaoH2()));
//    private OdontologoService odontologoService = new OdontologoService(new OdontologoDaoH2(new ConfiguracionJDBC()));
//    final static Logger log = Logger.getLogger(PacienteDaoH2.class);
//
//    public TurnoListRepository() {
//        this.configuracionJDBC = new ConfiguracionJDBC();
//    }
//
//    //    public TurnoListRepository() {
////        turnos = new ArrayList<>();
////    }
//
////    @Override
////    public Turno guardar(Turno turno) {
////        turnos.add(turno);
////        return turno;
////    }
//
//    @Override
//    public Turno guardar(Turno turno) {
//        log.debug("Registrando turno : " + turno.toString());
//        Connection connection = configuracionJDBC.conectarConBaseDeDatos();
//        Statement stmt = null;
//        turno.setPaciente(pacienteService.buscar(turno.getPaciente().getId()).get());
//        turno.setOdontologo(odontologoService.buscar(turno.getOdontologo().getId()).get());
//        String query = String.format("INSERT INTO turnos(paciente_id,odontologo_id,fecha) VALUES('%s','%s','%s')", turno.getPaciente().getId(),
//                turno.getOdontologo().getId(), turno.getFecha());
//        try {
//            stmt = connection.createStatement();
//            stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
//            ResultSet keys = stmt.getGeneratedKeys();
//            if (keys.next())
//                turno.setId(keys.getInt(1));
//            stmt.close();
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//        return turno;
//    }
//
//    @Override
//    public Optional<Turno> buscar(Integer id) {
//        return Optional.empty();
//    }
//
//    @Override
//    public void eliminar(Integer id) {
//
//    }
//
//    @Override
//    public List<Turno> buscarTodos() {
//        return null;
//    }
//
//    @Override
//    public Turno actualizar(Turno turno) {
//        return null;
//    }
//
////    @Override
////    public Optional<Turno> buscar(Integer id) {
////        return turnos.stream().filter(turno -> turno.getId().equals(id)).findFirst();
////    }
////
////    @Override
////    public void eliminar(Integer id) {
////        turnos.removeIf(turno -> turno.getId().equals(id));
////    }
////
////    @Override
////    public List<Turno> buscarTodos() {
////        return turnos;
////    }
////
////    @Override
////    public Turno actualizar(Turno turno) {
////        eliminar(turno.getId());
////        turnos.add(turno);
////        return turno;
////    }
//}
