package aufgabenblatt6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CorpusCount {

	public static void main(String[] args) throws IOException {
		new CorpusCount().run();
	}

	void run() throws IOException {
		readFile("files/emma.txt");
		readFile("files/sense.txt");
		readFile("files/persuasion.txt");
		sort();
		write();
	}

	private void readFile(String filename) throws IOException {
		FileReader fr = new FileReader(filename);
		BufferedReader br = new BufferedReader(fr);
		String line;
		while ((line = br.readLine()) != null) {
			String[] words = line.split(" ");
			for (String word : words) {
				countWord(word);
			}
		}
		br.close();
	}

	private void countWord(String word) {
		// TODO Auto-generated method stub
		
	}

	private void sort() {
		// TODO Auto-generated method stub

	}

	private void write() {
		// TODO Auto-generated method stub

	}
}
