package br.ufs.dcomp.ExemploUdpJava;

import java.net.*;

public class AppUDP1 {

    public static void main(String[] args) throws SocketException {
        try{
            System.out.print("[ Alocando porta UDP      ..................  ");
    	    DatagramSocket socket = new DatagramSocket(10000);
            System.out.println("[OK] ]");
            
            String msg = "Olá!!!";
            
            byte[] msg_buf = msg.getBytes();
            int msg_size = msg_buf.length;
            InetAddress destination_address = InetAddress.getByName("3.82.92.93");
            int destination_port = 20000;

            System.out.print("[ Montando datagrama UDP  ..................  ");
            DatagramPacket pacote_envio =
                    new DatagramPacket(msg_buf, msg_size, destination_address,
                            destination_port);
            System.out.println("[OK] ]");
            
            System.out.print("[ Enviando datagrama UDP  ..................  ");
            socket.send(pacote_envio);
            System.out.println("[OK] ]");

            DatagramPacket datagrama_recebido =
                    new DatagramPacket(msg_buf, msg_size, destination_address,
                            destination_port);
            System.out.print("[ Aguardando recebimento de mensagem  ..................  ");
            socket.receive(datagrama_recebido);
            byte[] received_data = datagrama_recebido.getData();
            String received_msg = new String(received_data);

            System.out.println("[OK] ]");
            System.out.println("  Mensagem:             "+ received_msg);

        } catch (Exception e){
            System.out.println(e.getMessage());
        }    
    }
}