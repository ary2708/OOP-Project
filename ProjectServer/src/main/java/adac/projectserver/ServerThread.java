/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adac.projectserver;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JOptionPane;

/**
 *
 * @author dell
 */
public class ServerThread extends Thread {
    ServerFrame serv;
    
    ObjectInputStream obin;
    ObjectOutputStream obout;
    
    ServerSocket serversocket;
    
    Socket sock;
    
    public ServerThread(ServerFrame serv){
        this.serv=serv;
        try{
            serversocket=new ServerSocket(ServerSettings.port);
            JOptionPane.showMessageDialog(serv, "Server has started");
            start();
            
        }
        catch(Exception e){
            
        }
    }
    @Override
    public void run(){
        while(true){
            try{
                sock=serversocket.accept();
               openR();
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        
            
    }
    private void openR(){
        try{
            
  
        obin=new ObjectInputStream(sock.getInputStream());
        obout=new ObjectOutputStream(sock.getOutputStream());
        MsgReceived mr= new MsgReceived(serv, obin, obout);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void sendMsg(String msg){
        try{
            obout.writeObject(msg.toString());
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public class MsgReceived extends Thread{
        ServerFrame serv;
        ObjectInputStream obin;
        ObjectOutputStream obout;
        
        public MsgReceived(ServerFrame serv, ObjectInputStream obin, ObjectOutputStream obout){
            this.serv=serv;
            this.obin=obin;
            this.obout=obout;
            start();
        }
        @Override
        public void run(){
            try{
          serv.jRec.setText(obin.readObject().toString());
              
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
    } 
}
