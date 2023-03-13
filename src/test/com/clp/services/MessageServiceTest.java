package test.com.clp.services;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import com.clp.data.DataStorage;
import com.clp.data.InMemoryDataStorage;
import com.clp.entity.FileAttach;
import com.clp.entity.Group;
import com.clp.entity.Message;
import com.clp.entity.User;
import com.clp.repository.Repository;
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
		storage.getMessage().deleteAll();
		storage.getUsers().deleteAll();
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
		User sender = new User();
		User receiver = new User();
		Message message = new Message(sender, "TestString", receiver, attachment);
		List<Message> listMessages = new ArrayList<>();
		Boolean result = storage.getMessage().insert(message);
		messageService.sendMessage(sender, "TestString", receiver, attachment);
		assertTrue(result);
	}

	@org.junit.jupiter.api.Test
	void testDeletMessage() {
		DataStorage storage = InMemoryDataStorage.getInstance();
		List<FileAttach> attachment = new ArrayList<FileAttach>();
		User sender = new User();
		User receiver = new User();
		attachment.add(new FileAttach("File1.txt", "1234", "Dir"));
		Message message = new Message(sender, "TestString", receiver, attachment);
		storage.getMessage().delete(message);
		messageService.deleteMessage(message);
		assertNotNull(messageService);
	}

	@org.junit.jupiter.api.Test
	void testGetAllMessage() {
		DataStorage storage = InMemoryDataStorage.getInstance();
		List<FileAttach> attachment = new ArrayList<FileAttach>();
		User sender = new User();
		User receiver = new User();
		attachment.add(new FileAttach("File1.txt", "1234", "Dir"));
		Message message = new Message(sender, "TestString", receiver, attachment);
		messageService.getAllMessage();
		assertNotNull(messageService);
	}

	@org.junit.jupiter.api.Test
	void testGetTopLatestMessages() {
		int numOfLastesMessages = 2;
		int notIncludeMessages = 1;
		DataStorage storage = InMemoryDataStorage.getInstance();
		List<FileAttach> attachment = new ArrayList<FileAttach>();
		attachment.add(new FileAttach("File1.txt", "1234", "Dir"));
		List<Message> latestMessages = new ArrayList<>();
		User sender = new User();
		User receiver = new User();
		latestMessages.add(new Message(sender, "Hello Phat", receiver, attachment));
		latestMessages.add(new Message(sender, "Hello Phat", receiver, attachment));
		latestMessages.add(new Message(sender, "Hi Phat", receiver, attachment));
		latestMessages.add(new Message(sender, "Hello Linh", receiver, attachment));
		messageService.getTopLatestMessages(numOfLastesMessages, notIncludeMessages);
		assertNull(latestMessages);
	}

	@org.junit.jupiter.api.Test
	void testFindMessageByKeyWord() {
		DataStorage storage = InMemoryDataStorage.getInstance();
		String keyword = "Hello";
		messageService.findMessageByKeyWord(keyword);
	}

	@org.junit.jupiter.api.Test
	void testCheckMember() {
		DataStorage storage = InMemoryDataStorage.getInstance();
		User user1 = new User("Cao", "123");
		User user2 = new User("Cao", "123");
		Group group = new Group() {
		};
		group.addUser(user2);
		group.addUser(user1);

		assertTrue(messageService.checkMember(user1, group));
		User user3 = new User("Phat", "123");
//		assertFalse(messageService.checkMember(user3, group));
	}

	@org.junit.jupiter.api.Test
	void testGetGroupsOfUser() {
		DataStorage storage = InMemoryDataStorage.getInstance();
		List<Group> groupsOfUser = new ArrayList<>();
		User user1 = new User("Cao", "123");
		User user2 = new User("Linh", "123");
		User user3 = new User("Phat", "123");
		Group group1 = new Group() {
		};
		Group group2 = new Group() {
		};
		Group group3 = new Group() {
		};
		group1.addUser(user1);
		group2.addUser(user2);
		group3.addUser(user3);
		storage.getGroup().insert(group1);
		storage.getGroup().insert(group2);
		storage.getGroup().insert(group3);
		messageService.getGroupsOfUser(user1);
	}

	@org.junit.jupiter.api.Test
	void testConversations() {
		DataStorage storage = InMemoryDataStorage.getInstance();
		User user1 = new User("Cao", "123");
		User user2 = new User("Linh", "123");
		User user3 = new User("Phat", "123");
		Group group1 = new Group() {
		};
		Group group2 = new Group() {
		};
		Group group3 = new Group() {
		};
		group1.addUser(user1);
		group2.addUser(user2);
		group3.addUser(user3);

		Message message1 = new Message(user1, "Hello Phat, How are you?");
		Message message2 = new Message(user2, "Hello Linh, Are you ok?");
		Message message3 = new Message(user3, "Hello Cao, What's your name?");
		List<List<Message>> conversation1 = messageService.GetConversations(user1);
		List<List<Message>> conversation2 = messageService.GetConversations(user2);
		List<List<Message>> conversation3 = messageService.GetConversations(user3);
		assertEquals(conversation1.size(), 0);
	}
}
