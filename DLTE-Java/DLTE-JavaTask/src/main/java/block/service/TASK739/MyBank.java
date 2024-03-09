package block.service.task739;

import javax.xml.crypto.Data;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

public interface MyBank{
//range by dates
    void filter(Date beforeDate, Date afterDate) ;
}

