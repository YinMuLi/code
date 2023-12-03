import { msg, request } from "@/api";
import COS from "cos-js-sdk-v5";
let bucket: string;
let region: string;
let prefix: string;
interface IResponse {
  /**
   * 资格证明
   */
  credentials: {
    tmpSecretId: string;
    tmpSecretKey: string;
    sessionToken: string;
  };
  expiredTime: number;
  startTime: number;
}
request<any>({
  url: "/api/cos/config",
  method: "GET",
}).then(
  (res) => {
    bucket = res.bucket;
    region = res.region;
    prefix = res.prefix;
  },
  (error) => {
    msg.error(error);
  }
);
export interface ICallback {
  success: (res: any) => void;
  error: (res: any) => void;
  progress?: (res: any) => void;
}
const cos = new COS({
  getAuthorization: (options, callback) => {
    request<IResponse>({
      url: "/api/cos",
      method: "GET",
    }).then(
      (res) => {
        let credentials = res.credentials;
        callback({
          TmpSecretId: credentials.tmpSecretId,
          TmpSecretKey: credentials.tmpSecretKey,
          SecurityToken: credentials.sessionToken,
          ExpiredTime: res.expiredTime,
          StartTime: res.startTime,
        });
      },
      (error) => {
        msg.error(error);
      }
    );
  },
});
export function upload(file: File, callback: ICallback) {
  cos.putObject(
    {
      Body: file,
      Bucket: bucket,
      Region: region,
      ACL: "public-read",
      Key: `${prefix}/${file.name}`,
    },
    (err, data) => {
      if (err != null) {
        callback.error(err);
      }
      if (data != null) {
        callback.success(data);
      }
    }
  );
}
