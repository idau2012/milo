/*
 * Copyright (c) 2018 Kevin Herron
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v1.0 which accompany this distribution.
 *
 * The Eclipse Public License is available at
 *   http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 *   http://www.eclipse.org/org/documents/edl-v10.html.
 */

package org.eclipse.milo.opcua.sdk.server.events.conversions;

import java.nio.ByteBuffer;
import java.util.UUID;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import io.netty.buffer.ByteBufUtil;
import org.eclipse.milo.opcua.stack.core.BuiltinDataType;
import org.eclipse.milo.opcua.stack.core.types.builtin.ByteString;

final class ByteStringConversions {

    private ByteStringConversions() {}

    @Nullable
    static UUID byteStringToGuid(@Nonnull ByteString bs) {
        if (bs.length() != 16) {
            return null;
        } else {
            ByteBuffer byteBuffer = ByteBuffer.wrap(bs.bytesOrEmpty());
            Long high = byteBuffer.getLong();
            Long low = byteBuffer.getLong();
            return new UUID(high, low);
        }
    }

    @Nonnull
    static String byteStringToString(@Nonnull ByteString bs) {
        return ByteBufUtil.hexDump(bs.bytesOrEmpty());
    }

    @Nullable
    static Object convert(@Nonnull Object o, BuiltinDataType targetType, boolean implicit) {
        if (o instanceof ByteString) {
            ByteString bs = (ByteString) o;

            return implicit ?
                implicitConversion(bs, targetType) :
                explicitConversion(bs, targetType);
        } else {
            return null;
        }
    }

    @Nullable
    static Object explicitConversion(@Nonnull ByteString bs, BuiltinDataType targetType) {
        //@formatter:off
        switch (targetType) {
            case Guid:      return byteStringToGuid(bs);
            case String:    return byteStringToString(bs);
            default:        return implicitConversion(bs, targetType);
        }
        //@formatter:on
    }

    @Nullable
    static Object implicitConversion(@Nonnull ByteString bs, BuiltinDataType targetType) {
        // no implicit conversions exist
        return null;
    }

}
