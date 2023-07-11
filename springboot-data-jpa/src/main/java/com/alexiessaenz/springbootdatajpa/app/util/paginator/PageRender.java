package com.alexiessaenz.springbootdatajpa.app.util.paginator;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class PageRender<T> {
    String url;
    Page<T> page;
    int totalPaginas;
    int numElementosPorPagina;
    int paginaActual;
    List<PageItem> paginas;

    public PageRender(String url, Page<T> page){
        this.url = url;
        this.page = page;
        this.paginas = new ArrayList<PageItem>();

        numElementosPorPagina = 6;
        totalPaginas = page.getTotalPages();
        paginaActual = page.getNumber()+1;

        int desde, hasta;
        if(totalPaginas <= numElementosPorPagina){
            desde = 1;
            hasta = totalPaginas;
        } else {
            if (paginaActual <= numElementosPorPagina/2){
                desde = 1;
                hasta = numElementosPorPagina;
            } else if (paginaActual >= totalPaginas - numElementosPorPagina /2) {
                desde = totalPaginas - numElementosPorPagina;
                hasta = numElementosPorPagina;
            } else {
                desde = paginaActual- numElementosPorPagina/2;
                hasta = numElementosPorPagina;
            }
        }

        for (int i = 0; i < hasta; i++)
            paginas.add(
                    new PageItem(
                            desde++,
                            paginaActual == desde++
                    )
            );


    }
    boolean isFirst(){
        return page.isFirst();
    }
    boolean isLast(){
        return page.isLast();
    }
    boolean isHasNext(){
        return page.hasNext();
    }
    boolean isHasPrevius(){
        return page.hasPrevious();
    }
}
