package org.livecloud.zlog.domain.mapper;

import java.util.List;

import org.livecloud.zlog.domain.entity.Options;

public interface OptionsMapper {

	List<Options> getOptions();

    void delete(Options g);

    Options findOne(long optionId);

    Options save(Options options);
}
