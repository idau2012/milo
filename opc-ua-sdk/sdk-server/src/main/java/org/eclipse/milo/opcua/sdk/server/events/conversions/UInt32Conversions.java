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

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.eclipse.milo.opcua.stack.core.types.builtin.StatusCode;
import org.eclipse.milo.opcua.stack.core.types.builtin.unsigned.UByte;
import org.eclipse.milo.opcua.stack.core.types.builtin.unsigned.UInteger;
import org.eclipse.milo.opcua.stack.core.types.builtin.unsigned.ULong;
import org.eclipse.milo.opcua.stack.core.types.builtin.unsigned.UShort;

import static org.eclipse.milo.opcua.stack.core.types.builtin.unsigned.Unsigned.ubyte;
import static org.eclipse.milo.opcua.stack.core.types.builtin.unsigned.Unsigned.ulong;
import static org.eclipse.milo.opcua.stack.core.types.builtin.unsigned.Unsigned.ushort;

final class UInt32Conversions {

    private UInt32Conversions() {}

    @Nonnull
    static Boolean uInt32ToBoolean(@Nonnull UInteger ui) {
        return ui.intValue() != 0;
    }

    @Nullable
    static UByte uInt32ToByte(@Nonnull UInteger ui) {
        long l = ui.longValue();

        if (l <= UByte.MAX_VALUE) {
            return ubyte(l);
        } else {
            return null;
        }
    }

    @Nonnull
    static Double uInt32ToDouble(@Nonnull UInteger ui) {
        return ui.doubleValue();
    }

    @Nonnull
    static Float uInt32ToFloat(@Nonnull UInteger ui) {
        return ui.floatValue();
    }

    @Nullable
    static Short uInt32ToInt16(@Nonnull UInteger ui) {
        int i = ui.intValue();

        if (i <= Short.MAX_VALUE) {
            return (short) i;
        } else {
            return null;
        }
    }

    @Nullable
    static Integer uInt32ToInt32(@Nonnull UInteger ui) {
        long l = ui.longValue();

        if (l <= Integer.MAX_VALUE) {
            return (int) l;
        } else {
            return null;
        }
    }

    @Nonnull
    static Long uInt32ToInt64(@Nonnull UInteger ui) {
        return ui.longValue();
    }

    @Nullable
    static Byte uInt32ToSByte(@Nonnull UInteger ui) {
        int i = ui.intValue();

        if (i <= Byte.MAX_VALUE) {
            return (byte) i;
        } else {
            return null;
        }
    }

    @Nonnull
    static StatusCode uInt32ToStatusCode(@Nonnull UInteger ui) {
        return new StatusCode(ui);
    }

    @Nonnull
    static String uInt32ToString(@Nonnull UInteger ui) {
        return ui.toString();
    }

    @Nullable
    static UShort uInt32ToUInt16(@Nonnull UInteger ui) {
        int i = ui.intValue();

        if (i <= UShort.MAX_VALUE) {
            return ushort(i);
        } else {
            return null;
        }
    }

    @Nonnull
    static ULong uInt32ToUInt64(@Nonnull UInteger ui) {
        return ulong(ui.longValue());
    }

}
