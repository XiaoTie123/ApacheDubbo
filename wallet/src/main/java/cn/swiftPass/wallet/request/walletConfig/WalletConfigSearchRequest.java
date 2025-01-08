package cn.swiftPass.wallet.request.walletConfig;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
public class WalletConfigSearchRequest implements Serializable {
    private Integer status;
    private Integer page;
    private Integer size;
}
