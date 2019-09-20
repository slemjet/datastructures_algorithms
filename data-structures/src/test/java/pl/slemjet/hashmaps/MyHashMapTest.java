package pl.slemjet.hashmaps;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class MyHashMapTest {
    @Test
    void testIfStoresAndRetrieves() {
        //given
        MyHashMap myHashMap = new MyHashMap(10);
        myHashMap.set("grapes", 10000);
        myHashMap.set("apples", 9);
        myHashMap.set("sdfsdffdsfewyujhg", 120);

        //when
        Integer grapes = myHashMap.get("grapes").getValue();
        Integer apples = myHashMap.get("apples").getValue();
        Integer sdfsdffdsfewyujhg = myHashMap.get("sdfsdffdsfewyujhg").getValue();
        String[] keys = myHashMap.getKeys();

        //then
        Assertions.assertThat(grapes).isEqualTo(10000);
        Assertions.assertThat(apples).isEqualTo(9);
        Assertions.assertThat(sdfsdffdsfewyujhg).isEqualTo(120);
        Assertions.assertThat(keys).containsExactlyInAnyOrder("grapes", "apples", "sdfsdffdsfewyujhg");
    }
}