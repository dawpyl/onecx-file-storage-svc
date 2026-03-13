package org.tkit.onecx.file.storage.rs.external.v1.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import gen.org.tkit.onecx.file.storage.rs.external.v1.model.FileMetadataResponseDTOV1;
import software.amazon.awssdk.services.s3.model.HeadObjectResponse;

@Mapper()
public interface MetadataMapper {

    @Mapping(target = "size", expression = "java(head.contentLength())")
    @Mapping(target = "type", expression = "java(head.contentType())")
    FileMetadataResponseDTOV1 map(HeadObjectResponse head, String fileName);
}
