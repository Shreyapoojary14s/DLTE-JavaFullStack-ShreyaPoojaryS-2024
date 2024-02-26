package blocks.service;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bonds {
    private Double maturityAmt;
    private Double interestRate;
    private boolean taxStatus;
    private String bondholder;
    private Integer period;
}