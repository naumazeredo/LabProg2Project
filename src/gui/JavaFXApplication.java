/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author naum
 */
public class JavaFXApplication extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader routeloader = new FXMLLoader(getClass().getResource("Route.fxml"));
        Parent root = (Parent)routeloader.load();
        Scene routescene = new Scene(root);
        RouteController routecontroller = (RouteController)routeloader.getController();
        
        FXMLLoader pilotloader = new FXMLLoader(getClass().getResource("Pilot.fxml"));
        root = (Parent)pilotloader.load();
        Scene pilotscene = new Scene(root);
        PilotController pilotcontroller = (PilotController)pilotloader.getController();
        
        pilotcontroller.SetRouteScene(stage, routescene, routecontroller);
        routecontroller.SetPilotScene(stage, pilotscene, pilotcontroller);
        
        stage.setTitle("Olimpíadas");
        stage.setScene(pilotscene);
        stage.show();
        
        // Pega localização e converte a data para o formato Date
        //routecontroller.Setup(location.getText(), Date.from(date.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()));
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
        /*
        EventoDAO evento = new EventoDAO();
        Evento evento0 = evento.create();
        Evento evento1 = evento.create();
        Evento evento2 = evento.create();
        Evento evento3 = evento.create();
        
        LocalizacaoDAO localizacao = new LocalizacaoDAO();
        Localizacao localizacao0 = localizacao.create();
        Localizacao localizacao1 = localizacao.create();
        Localizacao localizacao2 = localizacao.create();
        Localizacao localizacao3 = localizacao.create();
        
        TipoEventoDAO tipoevento = new TipoEventoDAO();
        TipoEvento tipoevento0 = tipoevento.create();
        TipoEvento tipoevento1 = tipoevento.create();
        TipoEvento tipoevento2 = tipoevento.create();
        TipoEvento tipoevento3 = tipoevento.create();
        
        tipoevento0.SetNome("hipismo");
        tipoevento0.SetDuracao(120);
        tipoevento1.SetNome("volei de praia");
        tipoevento1.SetDuracao(90);
        tipoevento2.SetNome("futebol");
        tipoevento2.SetDuracao(110);
        tipoevento3.SetNome("natacao");
        tipoevento3.SetDuracao(200);
        
        
        localizacao0.SetLocal("Centro Nacional de Hipismo");
        localizacao0.SetRegiao(Localizacao.Regiao.Deodoro);
        localizacao1.SetLocal("Praia de Ipanema");
        localizacao1.SetRegiao(Localizacao.Regiao.Copacabana);
        localizacao2.SetLocal("Estadio Jornalista Mario Filho");
        localizacao2.SetRegiao(Localizacao.Regiao.Maracana);
        localizacao3.SetLocal("Parque Aquatico Maria Lenk");
        localizacao3.SetRegiao(Localizacao.Regiao.Barra);
        //Date data;
        
        evento0.setNome("Competicao de saltos");
        evento0.setLocalId(1);
        evento0.setTipoId(1);
        evento0.setData(new Date(115, 10, 16, 10, 00, 00));
        evento1.setNome("Brasil X Argentina");
        evento1.setLocalId(2);
        evento1.setTipoId(2);
        evento1.setData(new Date(115, 10, 16, 12, 30, 00));
        evento2.setNome("Alemanha X Holanda");
        evento2.setLocalId(3);
        evento2.setTipoId(3);
        evento2.setData(new Date(115, 10, 16, 14, 00, 00));
        evento3.setNome("Revezamentos");
        evento3.setLocalId(4);
        evento3.setTipoId(4);
        evento3.setData(new Date(115, 10, 16, 18, 00, 00));
        
        
        //realizacao de testes
        evento.insert(evento0);
        evento.insert(evento1);
        evento.insert(evento2);
        evento.insert(evento3);
        */
        
    }
    
}
