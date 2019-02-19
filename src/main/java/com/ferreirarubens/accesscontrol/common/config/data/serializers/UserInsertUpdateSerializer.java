package com.ferreirarubens.accesscontrol.common.config.data.serializers;

import java.io.IOException;
import java.util.Objects;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.ferreirarubens.accesscontrol.common.model.User;

public class UserInsertUpdateSerializer extends StdSerializer<User> {

	private static final long serialVersionUID = 1L;

	public UserInsertUpdateSerializer() {
		this(null);
	}

	protected UserInsertUpdateSerializer(Class<User> t) {
		super(t);
	}

	@Override
	public void serialize(User user, JsonGenerator generator, SerializerProvider arg2) throws IOException {
		User newUser = new User();
		if (Objects.nonNull(user)) {
			newUser.setId(user.getId());
			newUser.setName(user.getName());
			newUser.setLogin(user.getLogin());
		}
		generator.writeObject(newUser);
	}

}
