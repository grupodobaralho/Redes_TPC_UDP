package udp;

import java.io.FileOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
/**
 * @author Israel Deorce
 * @date 18-Mar-2018 
 */
//"C:/Users/Israel-PC/Desktop/receber/arquivoRedes.txt"
public class UDPServer {

	public static void main(String a[]) throws Exception {

		// Inicialmente, precisamos de um DatagramSocket para aceitar o pacote
		// eh preciso definir a porta(argumento)
		DatagramSocket ds = new DatagramSocket(9999);

		byte b[] = new byte[11000];
		while (true) {
			DatagramPacket dp = new DatagramPacket(b, b.length);
			ds.receive(dp);
			// System.out.println(new String(dp.getData(),0,dp.getLength()));
			FileOutputStream f = new FileOutputStream("/home/labredes/Área de trabalho/Israel/output/arquivoRedes.txt");
			f.write(dp.getData());
			f.close();
		}
	}

}
