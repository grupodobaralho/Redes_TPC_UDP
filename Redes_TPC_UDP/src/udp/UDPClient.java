package udp;

import java.io.FileInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author Israel Deorce
 * @date 18-Mar-2018
 */
public class UDPClient {

	public static void main(String[] args) throws Exception {

		// Socket UDP
		DatagramSocket ds = new DatagramSocket(2000);

		// Especifica o endereco Inet
		//InetAddress ia = InetAddress.getLocalHost();
		InetAddress ia = InetAddress.getByName("192.168.0.14");

		// Especifica o Arquivo
		FileInputStream f = new FileInputStream("C:/Users/jonat/Desktop/Israel Jr/arquivoGrande.txt");

		// Carrega o arquivo no array de bytes
		byte b[] = new byte[11000];
		int i = 0;
		while (f.available() != 0) {
			b[i] = (byte) f.read();
			i++;
		}
		f.close();

		// Gera um pacote de datagrama e envia
		DatagramPacket dp = new DatagramPacket(b, i, ia, 9999);
		ds.send(dp);

	}

}
