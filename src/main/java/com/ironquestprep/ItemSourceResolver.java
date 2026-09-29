package com.ironquestprep;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public final class ItemSourceResolver
{
    private static final Pattern ITEM_ID_PATTERN =
            Pattern.compile(
                    "ItemID(?:\\.Cert)?\\.[A-Za-z0-9_]+"
            );

    private ItemSourceResolver()
    {
    }

    public static int[] resolve(
            String itemSource,
            String alternateSources)
    {
        Set<Integer> itemIds =
                new LinkedHashSet<>();

        addSource(
                itemIds,
                itemSource
        );

        if (alternateSources != null
                && !alternateSources.trim().isEmpty())
        {
            String[] alternatives =
                    alternateSources.split("\\|");

            for (String alternative : alternatives)
            {
                addSource(
                        itemIds,
                        alternative
                );
            }
        }

        int[] result =
                new int[itemIds.size()];

        int index = 0;

        for (Integer itemId : itemIds)
        {
            result[index++] = itemId;
        }

        return result;
    }

    private static void addSource(
            Set<Integer> itemIds,
            String source)
    {
        if (source == null)
        {
            return;
        }

        source = source.trim();

        if (source.isEmpty()
                || source.equals("-1"))
        {
            return;
        }

        if (source.startsWith(
                "ItemCollections."))
        {
            addCollection(
                    itemIds,
                    source.substring(
                            "ItemCollections.".length()
                    )
            );

            return;
        }

        if (source.startsWith(
                "KeyringCollection."))
        {
            /*
             * Keyring unlocks are not normal bank items.
             * We'll handle these separately later.
             */
            return;
        }

        if (source.startsWith(
                "ItemID."))
        {
            Integer itemId =
                    resolveItemId(source);

            if (itemId != null
                    && itemId > 0)
            {
                itemIds.add(itemId);
            }

            return;
        }

        /*
         * Handles expressions such as:
         *
         * Arrays.asList(
         *     ItemID.X,
         *     ItemID.Y
         * )
         */
        Matcher matcher =
                ITEM_ID_PATTERN.matcher(source);

        while (matcher.find())
        {
            Integer itemId =
                    resolveItemId(
                            matcher.group()
                    );

            if (itemId != null
                    && itemId > 0)
            {
                itemIds.add(itemId);
            }
        }
    }

    private static void addCollection(
            Set<Integer> itemIds,
            String collectionName)
    {
        String[] symbolicIds =
                GeneratedItemCollections.get(
                        collectionName
                );

        for (String symbolicId : symbolicIds)
        {
            addSource(
                    itemIds,
                    symbolicId
            );
        }
    }

    private static Integer resolveItemId(String source)
    {
        return GeneratedItemIds.get(source);
    }
}
