package com.ironquestprep;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.*;
import org.junit.Test;
import static org.junit.Assert.*;
public class GeneratedMappingIntegrityTest {
    @Test public void everyClassificationMatchesOriginalMapping() throws Exception {
        Map<String, GeneratedPrepClassification.Type> values = new TreeMap<>(GeneratedPrepClassification.build());
        assertEquals(1129, values.size());
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        DataOutputStream out = new DataOutputStream(bytes);
        for (Map.Entry<String, GeneratedPrepClassification.Type> entry : values.entrySet()) {
            for (String field : Arrays.asList(entry.getKey(), entry.getValue().name())) {
                byte[] encoded = field.getBytes(StandardCharsets.UTF_8);
                out.writeInt(encoded.length); out.write(encoded);
            }
        }
        StringBuilder hash = new StringBuilder();
        for (byte b : MessageDigest.getInstance("SHA-256").digest(bytes.toByteArray()))
            hash.append(String.format("%02x", b & 0xff));
        assertEquals("ece2335422d6a991cb82e6efe061df326204ba86b1e8b8111305d555263db172", hash.toString());
        assertEquals(GeneratedPrepClassification.Type.QUEST_OBTAINED,
                GeneratedPrepClassification.get("unknown", "unknown"));
    }
    @Test public void itemSymbolsStillRequireTheirNamespace() {
        assertEquals(Integer.valueOf(net.runelite.api.gameval.ItemID.KNIFE), GeneratedItemIds.get("ItemID.KNIFE"));
        assertNull(GeneratedItemIds.get("KNIFE"));
        assertNull(GeneratedItemIds.get("ItemID.NOT_A_REAL_ITEM"));
        assertNull(GeneratedItemIds.get(null));
    }
}
