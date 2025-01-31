package br.ufs.dcomp.ExemploUdpJava; 

import java.net.*;

public class AppUDP2 {

    public static void main(String[] args) throws SocketException {
        try{

            System.out.print("[ Alocando porta UDP                  ..................  ");
    	    DatagramSocket socket = new DatagramSocket(20000);
            System.out.println("[OK] ]");

            byte[] buf = new byte[20];
            DatagramPacket datagrama_recebido = new DatagramPacket(buf, buf.length);

            System.out.print("[ Aguardando recebimento de mensagem  ..................  ");
            socket.receive(datagrama_recebido);
            System.out.println("[OK] ]");
            
            byte[] received_data = datagrama_recebido.getData();
            String received_msg = new String(received_data); 
            InetAddress origin_address = datagrama_recebido.getAddress();
            int origin_port = datagrama_recebido.getPort();
            
            System.out.println("  Mensagem:             "+received_msg);
            System.out.println("  Endereço de origem:   "+origin_address.getHostAddress());
            System.out.println("  Porta de origem:      "+origin_port);

            String msg = "Olá de volta!!!";
            byte[] msg_buf = msg.getBytes();
            int msg_size = msg_buf.length;
            DatagramPacket datagrama_resposta =
                    new DatagramPacket(msg_buf, msg_size, origin_address,
                            origin_port);
            System.out.print("[ Enviando datagrama UDP  ..................  ");
            socket.send(datagrama_resposta);
            System.out.println("[OK] ]");

        } catch (Exception e){
            System.out.println(e.getMessage());
        }    
        
        
        
        

    }
}