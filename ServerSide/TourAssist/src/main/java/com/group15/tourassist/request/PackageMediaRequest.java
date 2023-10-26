package com.group15.tourassist.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class PackageMediaRequest {

    private byte[] image;

    private String description;

}