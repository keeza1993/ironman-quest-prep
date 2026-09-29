package com.ironquestprep;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
public class GeneratedQuestDataIntegrityTest {
    private static void field(DataOutputStream out, String value) throws IOException {
        byte[] bytes = value.getBytes(StandardCharsets.UTF_8);
        out.writeInt(bytes.length); out.write(bytes);
    }
    static String fingerprint() throws Exception {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        DataOutputStream out = new DataOutputStream(bytes);
        for (java.util.List<GeneratedQuestData.RawItem> rows : java.util.Arrays.asList(
                GeneratedQuestData.getItems(), GeneratedQuestData.getAdvisories())) {
            out.writeInt(rows.size());
            for (GeneratedQuestData.RawItem row : rows) {
            field(out, row.getQuest());
            field(out, row.getVariable());
            field(out, row.getRequirementClass());
            field(out, row.getItemName());
            field(out, row.getItemSource());
            field(out, row.getSourceType());
            field(out, row.getQuantity());
            field(out, Boolean.toString(row.isConsumed()));
            field(out, row.getAlternateSources());
            field(out, row.getCondition());
            field(out, row.getGroup());
            field(out, row.getConditionsJson());
            field(out, row.getStatus());
            field(out, row.getReason());
            field(out, row.getOriginalReview());
            field(out, row.getSourceFile());
            }
        }
        out.writeInt(GeneratedQuestData.getGroups().size());
        for (GeneratedQuestData.RawGroup row : GeneratedQuestData.getGroups()) {
            field(out, row.getQuest());
            field(out, row.getGroup());
            field(out, row.getLogic());
            field(out, row.getChildren());
            field(out, row.getDescription());
            field(out, row.getArgumentText());
            field(out, row.getCondition());
            field(out, row.getConditionsJson());
            field(out, Boolean.toString(row.isConsumed()));
            field(out, row.getStatus());
            field(out, row.getReason());
            field(out, row.getOriginalReview());
            field(out, row.getBranchesJson());
            field(out, row.getSourceFile());
        }
        out.flush();
        StringBuilder hex = new StringBuilder();
        for (byte b : MessageDigest.getInstance("SHA-256").digest(bytes.toByteArray()))
            hex.append(String.format("%02x", b & 0xff));
        return hex.toString();
    }
    @org.junit.Test
    public void compactDataPreservesEveryOriginalFieldAndRowOrder() throws Exception {
        org.junit.Assert.assertEquals("29d7afd5a276b571f7228f49c9780b346d9d8d8859ff9230f3babcc214b3ef90", fingerprint());
        org.junit.Assert.assertEquals(1129, GeneratedQuestData.getItems().size());
        org.junit.Assert.assertEquals(97, GeneratedQuestData.getAdvisories().size());
        org.junit.Assert.assertEquals(61, GeneratedQuestData.getGroups().size());
    }
    public static void main(String[] args) throws Exception { System.out.println(fingerprint()); }
}
