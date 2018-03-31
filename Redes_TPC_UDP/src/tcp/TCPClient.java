package tcp;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author Israel Deorce
 * @date 18-Mar-2018
 */

//InetAddress.getByName("localhost")
public class TCPClient {

	public static void main(String[] args) throws Exception {

		// Inicializa o Socket
		Socket socket = new Socket(InetAddress.getLocalHost(), 5000);
		byte[] contents = new byte[10000];

		// Inicializa o FileOutputStream para o endereco de saida completo do arquivo
		FileOutputStream fos = new FileOutputStream("C:/Users/Israel-PC/Desktop/receber/arquivoRedes.txt");
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		InputStream is = socket.getInputStream();

		// Numero de bytes lido em uma chamada read()
		int bytesRead = 0;

		while ((bytesRead = is.read(contents)) != -1)
			bos.write(contents, 0, bytesRead);

		bos.flush();
		socket.close();

		System.out.println("Arquivo salvo com sucesso!");
	}
}
