package tcp;

import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.io.BufferedInputStream;
import java.io.File;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author Israel Deorce
 * @date 18-Mar-2018 https://www.youtube.com/watch?v=A5fFxs_DUsQ&t=152s
 */

public class TCPServer {

	public static void main(String[] args) throws Exception {
		// Inicializa sockets
		ServerSocket ssock = new ServerSocket(5000);
		Socket socket = ssock.accept();

		// Especifica o endereco Inet
		InetAddress IA = InetAddress.getLocalHost();

		// Especifica o arquivo
		File file = new File("C:/Users/Israel-PC/Desktop/arquivoRedes.txt");
		FileInputStream fis = new FileInputStream(file);
		BufferedInputStream bis = new BufferedInputStream(fis);

		// Pega o output stream do socket
		OutputStream os = socket.getOutputStream();

		// Le o arquivo no array de bytes
		byte[] contents;
		long fileLength = file.length();
		long current = 0;

		long start = System.nanoTime();
		while (current != fileLength) {
			int size = 10000;
			if (fileLength - current >= size)
				current += size;
			else {
				size = (int) (fileLength - current);
				current = fileLength;
			}
			contents = new byte[size];
			bis.read(contents, 0, size);
			os.write(contents);
			System.out.print("Enviando arquivo ... " + (current * 100) / fileLength + "% concluido!");
		}

		os.flush();
		// Transferencia de arquivo concluida. Fecha a conexao do socket!
		socket.close();
		ssock.close();
		System.out.println("Arquivo enviado com sucesso!");
	}
}
