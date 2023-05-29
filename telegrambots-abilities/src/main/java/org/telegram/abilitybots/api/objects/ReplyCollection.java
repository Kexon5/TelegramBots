package org.telegram.abilitybots.api.objects;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.google.common.collect.Lists.newArrayList;

/**
 * A wrapping object containing Replies. Return this in your bot class to get replies registered.
 *
 * @see Reply
 */
public class ReplyCollection {

    public final Collection<? extends Reply> replies;

    public ReplyCollection(Collection<? extends Reply> replies) {
        this.replies = replies;
    }

    public Collection<? extends Reply> getReplies() {
        return replies;
    }

    public Stream<? extends Reply> stream() {
        return replies.stream()
                      .flatMap(Reply::stream);
    }

    public static <T extends Reply> ReplyCollection of(T... replies) {
        return new ReplyCollection(newArrayList(replies));
    }
}
