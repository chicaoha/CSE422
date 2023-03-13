package test.com.clp.services;

import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import com.clp.data.DataStorage;
import com.clp.data.InMemoryDataStorage;
import com.clp.entity.FileAttach;
import com.clp.entity.Message;
import com.clp.services.MessageService;
import com.clp.services.UserService;

public class MessageServiceTest {
	private MessageService messageService;
	private UserService userService;

	@org.junit.jupiter.api.BeforeEach
	void setUp() {
		DataStorage storage = InMemoryDataStorage.getInstance();
		messageService = new MessageService(storage);
		userService = new UserService(storage);
	}

	@org.junit.jupiter.api.AfterEach
	void tearDown() {
		DataStorage storage = InMemoryDataStorage.getInstance();
		storage.getGroup().deleteAll();
	}

	@org.junit.jupiter.api.Test
	void testSaveFile() throws IOException {
		DataStorage storage = InMemoryDataStorage.getInstance();
		byte[] testData = new byte[] { 1, 2, 3, 4, 5 };
		InputStream inputStream = new ByteArrayInputStream(testData);
		byte[] buffer = new byte[3];
		int bytesRead = inputStream.read(buffer);
		File file = new File("Dir");
		messageService.saveFile(inputStream, file);
	}

	@org.junit.jupiter.api.Test
	void testSendMessage() {
		DataStorage storage = InMemoryDataStorage.getInstance();
		List<FileAttach> attachment = new ArrayList<FileAttach>();
		attachment.add(new FileAttach("File1.txt", "1234", "Dir"));
		Message message = new Message("Cao", "TestString", "Phat", attachment);
		List<Message> listMessages = new ArrayList<>();
		Boolean result = storage.getMessage().insert(message);
		messageService.sendMessage("Cao", "TestString", "Phat", attachment);
		assertTrue(result);
	}
}
