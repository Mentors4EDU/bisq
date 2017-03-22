/*
 * This file is part of bisq.
 *
 * bisq is free software: you can redistribute it and/or modify it
 * under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or (at
 * your option) any later version.
 *
 * bisq is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU Affero General Public
 * License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with bisq. If not, see <http://www.gnu.org/licenses/>.
 */

package io.bisq.core.util;

import io.bisq.protobuffer.message.trade.TradeMessage;
import org.bitcoinj.core.Coin;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Utility class for validating domain data.
 */
public class Validator {

    public static String nonEmptyStringOf(String value) {
        checkNotNull(value);
        checkArgument(value.length() > 0);
        return value;
    }

    public static long nonNegativeLongOf(long value) {
        checkArgument(value >= 0);
        return value;
    }

    public static Coin nonZeroCoinOf(Coin value) {
        checkNotNull(value);
        checkArgument(!value.isZero());
        return value;
    }

    public static Coin positiveCoinOf(Coin value) {
        checkNotNull(value);
        checkArgument(value.isPositive());
        return value;
    }

    public static void checkTradeId(String tradeId, TradeMessage tradeMessage) {
        checkArgument(tradeId.equals(tradeMessage.tradeId));
    }
}
