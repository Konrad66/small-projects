package org.example.advanced.stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MyStreamServiceTest {
    //Given
    private StreamService service = new MyStreamService();
    private List<String> names = new ArrayList<>(Arrays.asList("Marcin", "Zbyszek", "Kasia", "Zosia", "Kasia", "Magda", "Iza"));
    private int[] primeNumbers = {2, 79, 83, 41, 43, 47, 53, 59, 13, 17, 83, 31,
            37, 61, 67, 89, 3, 5, 7, 7, 11, 71, 73, 97, 19, 19, 23, 29};


    @Test
    void sortAndPrintShouldSortNames(){
        //given
        List<String> resultExpected = List.of("Marcin", "Zbyszek", "Kasia", "Zosia", "Kasia", "Magda", "Iza");
        //when

        //then
        //Assertions.(resultExpected,service.sortAndPrint(names));
    }

    @Test
    void distinctAndCountNumbersShouldReturnAmountOFNumbers(){
        //given
        //when
        int result = service.distinctAndCountNumbers(primeNumbers);
        //then
        Assertions.assertEquals(25,result);
    }

    @Test
    void computeMaleNamesShouldFilter(){
        //Given
        List<String> resultExpected = List.of("Marcin", "Zbyszek");
        //When
        List<String> result= service.computeMaleNames(names);
        //Then
        // Assertions.assertEquals(2, result.size());
        Assertions.assertEquals(resultExpected, result);
        //Assertions.assertSame(resultExpected, result);
    }

}