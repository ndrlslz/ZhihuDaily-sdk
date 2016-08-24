package me.ndrlslz.deserializer;

import com.google.gson.*;
import me.ndrlslz.model.Comment;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class CommentsDeserializer implements JsonDeserializer<List<Comment>> {
    @Override
    public List<Comment> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject object = json.getAsJsonObject();
        JsonArray array = object.get("comments").getAsJsonArray();
        List<Comment> list = new ArrayList<>();
        array.forEach(jsonElement -> list.add(context.deserialize(jsonElement, Comment.class)));
        return list;
    }
}
