package ru.job4j.task;

import java.util.*;

/**
 * This class represents sort of Department.
 * @author Svyatoslav Sabirov.
 * @since 28.02.2018
 * @version 7.
 */
public class Department {

    /**
     * Сортирует массив подразделений.
     * @param departments - массив подразделений.
     * @param desc - по возврастанию/убыванию.
     * @return - подразделения в нужном порядке.
     */
    public List<String> sort(String[] departments, boolean desc) {
        List<String> departmentList = new ArrayList(Arrays.asList(departments));
        ListIterator<String> departmentIterator = departmentList.listIterator();
        while (departmentIterator.hasNext()) {
            String currentDepartment = departmentIterator.next();
            if (currentDepartment.indexOf("\\") > 0) {
                String[] currentDepartments = currentDepartment.split("\\\\");
                String value = "";
                for (String part: currentDepartments) {
                    value += value == "" ? part : "\\" + part;
                    if (!departmentList.contains(value)) {
                        departmentIterator.add(value);
                    }
                }
            }
        }
        departmentList.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (desc) {
                    return o1.compareTo(o2);
                } else {
                    char[] firstArray = o1.toCharArray();
                    char[] secondArray = o2.toCharArray();
                    int index = 0;
                    int result = 0;
                    while ((index != firstArray.length) && (index != secondArray.length)) {
                        result = String.valueOf(secondArray[index]).compareTo(String.valueOf(firstArray[index]));
                        if (result != 0) {
                            break;
                        }
                        index++;
                    }
                    if (result == 0) {
                        result = index != firstArray.length ? 1 : result;
                        result = index != secondArray.length ? -1 : result;
                    }
                    return result;
                }
            }
        });
        return departmentList;
    }
}
