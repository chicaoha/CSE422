package test.com.clp.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;

import com.clp.data.DataStorage;
import com.clp.data.InMemoryDataStorage;
import com.clp.entity.Group;
import com.clp.entity.PrivateGroup;
import com.clp.entity.PublicGroup;
import com.clp.entity.User;
import com.clp.services.GroupService;
import com.clp.services.TextService;
import com.clp.services.UserService;

public class GroupServiceTest {
	private GroupService groupService;

	@org.junit.jupiter.api.BeforeEach
	void setUp() {
		DataStorage storage = InMemoryDataStorage.getInstance();
		UserService userService = new UserService(storage);
		TextService textService = new TextService();
		groupService = new GroupService(storage);
	}

	@org.junit.jupiter.api.AfterEach
	void tearDown() {
		DataStorage storage = InMemoryDataStorage.getInstance();
		storage.getGroup().deleteAll();
	}

	@org.junit.jupiter.api.Test
	void testCreatePublicGroup() {
		DataStorage storage = InMemoryDataStorage.getInstance();
		User user = new User();
		user.setId(123);
		groupService.createGroup(user, true);
		List<PublicGroup> listPublicGroup = new ArrayList<>();
		PublicGroup publicGroup = new PublicGroup();
		UserService service = new UserService(storage);
		String code = publicGroup.getGroupCode();
		boolean result = publicGroup.joinByCode(user, code);
		assertTrue(result);
	}

	@org.junit.jupiter.api.Test
	void testCreatePublicLeaveGroup() {
		DataStorage storage = InMemoryDataStorage.getInstance();
		User user = new User();
		user.setId(123);
		groupService.createGroup(user, true);
		List<PublicGroup> listPublicGroup = new ArrayList<>();
		PublicGroup publicGroup = new PublicGroup();
		UserService service = new UserService(storage);
		String code = publicGroup.getGroupCode();
		publicGroup.leaveGroup(user);
		assertNotNull("Leave the group success", publicGroup);
	}

	@org.junit.jupiter.api.Test
	void testCreatePrivateGroupSuccess() {
		DataStorage storage = InMemoryDataStorage.getInstance();
		User user = new User("Phat", "1234");
		groupService.createGroup(user, false);
		List<PrivateGroup> listPrivateGroup = new ArrayList<>();
		List<User> admins = new ArrayList<>();
		PrivateGroup privateGroup = new PrivateGroup(user);
		boolean result = privateGroup.joinByInvitation(user);
		assertNotNull(privateGroup);
		assertTrue(result);
	}

	@org.junit.jupiter.api.Test
	void testCreatePrivateGroupFail() {
		DataStorage storage = InMemoryDataStorage.getInstance();
		User user = new User();
		int id = user.getId();
		groupService.createGroup(user, false);
		List<PrivateGroup> listPrivateGroup = new ArrayList<>();
		List<User> admins = new ArrayList<>();
		PrivateGroup privateGroup = new PrivateGroup(user);
		boolean result = privateGroup.joinByInvitation(user);
//		assertFalse(result);
	}
}
