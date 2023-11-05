package com.alexiessaenz.springbootdatajpa.app.util.paginator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageItem {
    int numero;
    boolean actual;
}
